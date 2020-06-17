package br.com.darksun.entity;

import java.util.ArrayList;

public class Localizacao
{
	private String nome;
	private String descricao;
	private Localizacao local;

	private ArrayList< Personagem > residentes = new ArrayList( );

	public Localizacao( )
	{

	}

	public Localizacao( String nome )
	{
		this.nome = nome;
	}

	public Localizacao( String nome, String descricao, Localizacao local )
	{
		this.nome = nome;
		this.descricao = descricao;
		this.local = local;
	}

	public String getNome( )
	{
		return this.nome;
	}

	public void setNome( String nome )
	{
		this.nome = nome;
	}

	public String getDescicao( )
	{
		return this.descricao;
	}

	public void setDescicao( String descicao )
	{
		this.descricao = descicao;
	}

	public Localizacao getLocal( )
	{
		return this.local;
	}

	public void setLocal( Localizacao local )
	{
		this.local = local;
	}

	public ArrayList< Personagem > getResidentes( )
	{
		return this.residentes;
	}

	public void addResidentes( Personagem personagem )
	{
		if ( !this.residentes.contains( personagem ) )
		{
			this.residentes.add( personagem );
		}
		if ( personagem.getLocal( ) != this )
		{
			personagem.setLocal( this );
		}
	}

	public void removeResidentes( Personagem personagem )
	{
		if ( this.residentes.contains( personagem ) )
		{
			this.residentes.remove( personagem );

			if ( personagem.getLocal( ) == this )
			{
				personagem.setLocal( null );
			}
		}
	}

}
