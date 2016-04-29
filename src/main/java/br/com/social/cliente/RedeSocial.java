package br.com.social.cliente;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RedeSocial {

	private Long id;
	private String nomeRedeSocial;
	private String nomeUsuario;
	private Long usuarioId;
	private String nomeUsuarioJoin;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeRedeSocial() {
		return nomeRedeSocial;
	}

	public void setNomeRedeSocial(String nomeRedeSocial) {
		this.nomeRedeSocial = nomeRedeSocial;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getNomeUsuarioJoin() {
		return nomeUsuarioJoin;
	}

	public void setNomeUsuarioJoin(String nomeUsuarioJoin) {
		this.nomeUsuarioJoin = nomeUsuarioJoin;
	}

	@Override
	public String toString() {
		return "RedeSocial [id=" + id + ", nomeRedeSocial=" + nomeRedeSocial
				+ ", nomeUsuario=" + nomeUsuario + ", usuarioId=" + usuarioId
				+ ", nomeUsuarioJoin=" + nomeUsuarioJoin + "]";
	}

}
