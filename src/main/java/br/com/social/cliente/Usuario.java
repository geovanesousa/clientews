package br.com.social.cliente;

import java.util.Arrays;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * Classe que contém os atributos do usuário JOIN
 * 
 * @author equipe
 *
 * @since 18/04/2016 15:45:43
 */
@XmlRootElement
public class Usuario {

	private Integer id;
	private String nomeUsuario;
	private String nomeCompleto;
	private String biografia;
	private String senha;
	private String email;
	private byte[] foto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nomeUsuario=" + nomeUsuario
				+ ", nomeCompleto=" + nomeCompleto + ", biografia=" + biografia
				+ ", senha=" + senha + ", email=" + email + ", foto="
				+ Arrays.toString(foto) + "]";
	}

}
