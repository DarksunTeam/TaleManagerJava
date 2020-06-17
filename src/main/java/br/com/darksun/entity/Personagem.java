package br.com.darksun.entity;

import java.time.LocalDate;
import java.util.ArrayList;

public class Personagem
{
	private String nome;
	private String raca;
	private String familia;
	private String sexo;
	private String caracteristicasFisicas;
	private String background;
	private String interpretacao;
	private Localizacao local;
	private LocalDate dataNascimento;
	private LocalDate dataMorte;

	private ArrayList< Relacionamento > relacoes = new ArrayList( );

	public Personagem( )
	{

	}

	public Personagem( String nome, String raca, String familia, String sexo, String caracteristicasFisicas,
			String background, String interpretacao, Localizacao local, LocalDate dataNascimento, LocalDate dataMorte )
	{
		this.nome = nome;
		this.raca = raca;
		this.familia = familia;
		this.sexo = sexo;
		this.caracteristicasFisicas = caracteristicasFisicas;
		this.background = background;
		this.interpretacao = interpretacao;
		this.local = local;
		if ( !local.getResidentes( ).contains( this ) )
		{
			local.addResidentes( this );
		}
		this.dataNascimento = dataNascimento;
		this.dataMorte = dataMorte;
	}

	public String getNome( )
	{
		return this.nome;
	}

	public void setNome( String nome )
	{
		this.nome = nome;
	}

	public String getRaca( )
	{
		return this.raca;
	}

	public void setRaca( String raca )
	{
		this.raca = raca;
	}

	public String getFamilia( )
	{
		return this.familia;
	}

	public void setFamilia( String familia )
	{
		this.familia = familia;
	}

	public String getSexo( )
	{
		return this.sexo;
	}

	public void setSexo( String sexo )
	{
		this.sexo = sexo;
	}

	public String getCaracteristicasFisicas( )
	{
		return this.caracteristicasFisicas;
	}

	public void setCaracteristicasFisicas( String caracteristicasFisicas )
	{
		this.caracteristicasFisicas = caracteristicasFisicas;
	}

	public String getBackground( )
	{
		return this.background;
	}

	public void setBackground( String background )
	{
		this.background = background;
	}

	public String getInterpretacao( )
	{
		return this.interpretacao;
	}

	public void setInterpretacao( String interpretacao )
	{
		this.interpretacao = interpretacao;
	}

	public Localizacao getLocal( )
	{
		return this.local;
	}

	public void setLocal( Localizacao local )
	{
		if ( this.local != null )
		{
			this.local.removeResidentes( this );
		}
		this.local = local;
		if ( local != null && !local.getResidentes( ).contains( this ) )
		{
			local.addResidentes( this );
		}
	}

	public LocalDate getDataInicio( )
	{
		return this.dataNascimento;
	}

	public void setDataInicio( LocalDate dataNascimento )
	{
		this.dataNascimento = dataNascimento;
	}

	public LocalDate getDataFim( )
	{
		return this.dataMorte;
	}

	public void setDataFim( LocalDate dataMorte )
	{
		this.dataMorte = dataMorte;
	}

	public ArrayList< Relacionamento > getRelacoes( )
	{
		return this.relacoes;
	}

	public void addRelacoes( Relacionamento relacao )
	{
		this.relacoes.add( relacao );
	}

	public void removeRelacoes( Relacionamento relacao )
	{
		this.relacoes.remove( relacao );
	}

}
