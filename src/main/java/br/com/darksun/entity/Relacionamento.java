package br.com.darksun.entity;

public class Relacionamento
{
	private String tipo;
	private Personagem personagem;

	public Relacionamento( )
	{

	}

	public Relacionamento( String tipo, Personagem personagem )
	{
		this.tipo = tipo;
		this.personagem = personagem;
	}

	public String getTipo( )
	{
		return tipo;
	}

	public void setTipo( String tipo )
	{
		this.tipo = tipo;
	}

	public Personagem getPersonagem( )
	{
		return personagem;
	}

	public void setPersonagem( Personagem personagem )
	{
		this.personagem = personagem;
	}

}
