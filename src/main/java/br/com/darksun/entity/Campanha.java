package br.com.darksun.entity;

import java.util.ArrayList;

public class Campanha
{
	private String nome;
	private String descicao;

	private ArrayList< Personagem > primarios = new ArrayList( );
	private ArrayList< Personagem > secundarios = new ArrayList( );

	private ArrayList< Localizacao > lugares = new ArrayList( );

	private Campanha( )
	{

	}

	private Campanha( String nome, String descicao )
	{
		this.nome = nome;
		this.descicao = descicao;
	}

	public String getNome( )
	{
		return nome;
	}

	public void setNome( String nome )
	{
		this.nome = nome;
	}

	public String getDescicao( )
	{
		return this.descicao;
	}

	public void setDescicao( String descicao )
	{
		this.descicao = descicao;
	}

	public ArrayList< Personagem > getPrimarios( )
	{
		return this.primarios;
	}

	public void addPrimarios( Personagem primario )
	{
		this.primarios.add( primario );
	}

	public void removePrimarios( Personagem primario )
	{
		this.primarios.remove( primario );
	}

	public ArrayList< Personagem > getSecundarios( )
	{
		return this.secundarios;
	}

	public void addSecundarios( Personagem secundario )
	{
		this.secundarios.add( secundario );
	}

	public void removeSecundarios( Personagem secundario )
	{
		this.secundarios.remove( secundario );
	}

	public ArrayList< Localizacao > getlugares( )
	{
		return this.lugares;
	}

	public void addlugares( Localizacao lugar )
	{
		this.lugares.add( lugar );
	}

	public void removelugares( Localizacao lugar )
	{
		this.lugares.remove( lugar );
	}

}
