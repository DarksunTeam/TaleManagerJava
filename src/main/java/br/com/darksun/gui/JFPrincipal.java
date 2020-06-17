package br.com.darksun.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class JFPrincipal extends JFrame
{
	private Integer largura = 1600;
	private Integer altura = 900;
	private JPInicial tela = new JPInicial( );

	public JFPrincipal( )
	{
		this.setSize( this.largura, this.altura );
		this.setVisible( true );
		this.setLayout( null );
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.add( tela );
	}

	public static void main( String[ ] args )
	{
		EventQueue.invokeLater( new Runnable( )
		{
			public void run( )
			{
				new JFPrincipal( );
			}
		} );
	}

}
