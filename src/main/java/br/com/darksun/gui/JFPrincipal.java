package br.com.darksun.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class JFPrincipal extends JFrame
{
	private Integer width = 1600;
	private Integer height = 900;

	public JFPrincipal( )
	{
		this.setSize( this.width, this.height );
		this.setUndecorated( true );
		this.setVisible( true );
		this.setLayout( null );
		this.setLocationRelativeTo( null );
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		JPTitleBar titleBar = new JPTitleBar( this );
		JPInicial tela = new JPInicial( this );

		this.add( titleBar );
		this.add( tela );
	}

	public void maximize( )
	{
		this.setExtendedState( JFrame.MAXIMIZED_BOTH );
	}

	public void resize( )
	{
		this.setSize( this.width, this.height );
	}

	public void minimize( )
	{
		this.setExtendedState( JFrame.ICONIFIED );
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
