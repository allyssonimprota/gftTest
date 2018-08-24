package com.improtainfo.gft_dev;

/**
 * Item de Base para implementação da Atividade.
 * @author Allysson
 */
public class ItemVO implements Comparable<ItemVO> {
	
	private String tipo;

	private String nome;
	
	private String turno;

	public ItemVO() {
		super();
	}

	public ItemVO(String tipo, String nome, String turno) {
		super();
		this.tipo = tipo;
		this.nome = nome;
		this.turno = turno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public int compareTo(ItemVO o) {
		return tipo.compareToIgnoreCase(o.getTipo());
	}

}
