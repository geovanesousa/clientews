package br.com.social.cliente;

import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class OperacoesDeUsuario {

	public void inserirUsuario() {
		Client client = ClientBuilder.newClient();
		Usuario u = new Usuario();
		u.setNomeUsuario("geovaneads");
		u.setNomeCompleto("Geovane Sousa");
		u.setBiografia("Estudante");
		u.setSenha("12345");
		u.setEmail("geovanesousa123@gmail.com");

		try {
			ImageIcon foto = new ImageIcon("imagens/eu.jpg");
			byte[] imagemExibidaByte = null;
			System.out
					.println(foto.getIconWidth() + "|" + foto.getIconHeight());
			BufferedImage bimg = new BufferedImage(foto.getIconWidth(),
					foto.getIconHeight(), BufferedImage.TYPE_INT_RGB);
			bimg.createGraphics().drawImage(foto.getImage(), 0, 0, null);
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			ImageIO.write(bimg, "jpg", buffer);

			imagemExibidaByte = buffer.toByteArray();
			u.setFoto(imagemExibidaByte);

			/*
			 * WebTarget target = client
			 * .target("http://social-geovanesousa.rhcloud.com/usuario/inserir"
			 * );
			 */
			WebTarget target = client
					.target("http://localhost:8080/social/usuario/inserir");
			Response response = target.request().post(Entity.json(u));
			String resposta = response.readEntity(String.class);
			System.out.println(resposta);
		} catch (IOException | HeadlessException e) {
			System.out.println("Erro ao ler imagem selecionada");
		} catch (ProcessingException e) {
			System.out
					.println("Falha ao se conectar com o serviço web! O serviço pode estar indisponivel.");
		}
	}

	/*
	 * public void atualizarUsuario() { Client client =
	 * ClientBuilder.newClient(); Usuario u = new Usuario();
	 * u.setNomeUsuario("geovaneads");
	 * u.setNomeCompleto("Geovane Sousa de Oliveira");
	 * 
	 * try { WebTarget target = client
	 * .target("http://localhost:8080/social/usuario/inserir"); Response
	 * response = target.request().post(Entity.json(u)); Usuario resposta =
	 * response.readEntity(Usuario.class); } catch (WebApplicationException e) {
	 * System.out .println("Já existe um usuário com esse NOME DE USUÁRIO!"); }
	 * }
	 */

	public void consultarUsuario() {
		Client client = ClientBuilder.newClient();

		Usuario u = new Usuario();
		u.setNomeUsuario("geovaneads");

		/*
		 * WebTarget target = client
		 * .target("http://social-geovanesousa.rhcloud.com/usuario/nome_de_usuario"
		 * );
		 */
		WebTarget target = client
				.target("http://localhost:8080/social/usuario/nome_de_usuario");
		try {
			Response response = target.request().post(Entity.json(u));
			Usuario resposta = response.readEntity(Usuario.class);
			String caminhoSalvar = "/home/geovane/Imagens/"
					+ resposta.getNomeUsuario() + ".jpg";
			File file = new File(caminhoSalvar);
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream(file));
			bos.write(resposta.getFoto());
			bos.close();
			System.out.println("Usuário encontrado com sucesso!");
			try {
				int i = 0;
				while (true) {
					RedeSocial rede = resposta.getRedesSociais().get(i);
					System.out.println("---------------------");
					System.out.println(rede.getNomeRedeSocial());
					System.out.println(rede.getNomeUsuario());
					i++;
				}
			} catch (IndexOutOfBoundsException e) {

			}
		} catch (WebApplicationException e) {
			System.out.println("Usuário não encontrado!");
		} catch (ProcessingException e) {
			System.out
					.println("Falha ao se conectar com o serviço web! O serviço pode estar indisponivel.");
		} catch (FileNotFoundException e) {
			System.out.println("Erro na foto do usuário" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Erro na foto do usuário" + e.getMessage());
		}

	}

	public void inserirRedeSocial() {
		Client client = ClientBuilder.newClient();
		RedeSocial rede = new RedeSocial();
		rede.setNomeRedeSocial("Whatsapp");
		rede.setNomeUsuario("+5585997204989");
		rede.setNomeUsuarioJoin("geovaneads");

		try {
			/*
			 * WebTarget target = client
			 * .target("http://social-geovanesousa.rhcloud.com/rede_inserir/inserir"
			 * );
			 */
			WebTarget target = client
					.target("http://localhost:8080/social/rede_social/inserir");

			Response response = target.request().post(Entity.json(rede));
			String resposta = response.readEntity(String.class);
			System.out.println(resposta);
		} catch (ProcessingException e) {
			System.out.println("Falha ao se conectar com o serviço web! "
					+ "O serviço pode estar indisponivel: " + e.getMessage());
		}
	}

}
