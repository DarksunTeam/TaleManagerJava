package br.com.darksun.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class JFPrincipal extends JFrame
{
	private Integer width = 1600;
	private Integer height = 900;
	private JPInicial tela = new JPInicial( );

	public JFPrincipal( )
	{
		this.setSize( this.width, this.height );
		this.setUndecorated( true );
		this.setVisible( true );
		this.setLayout( null );
		this.setLocationRelativeTo( null );
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		JPTitleBar titleBar = new JPTitleBar( this );

		this.add( titleBar );
		this.add( tela );
	}

	public void maximizar( )
	{
		this.setExtendedState( JFrame.MAXIMIZED_BOTH );
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
