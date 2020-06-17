package br.com.darksun.gui;

import java.awt.Color;

import javax.swing.JPanel;

public abstract class JPPadrao extends JPanel
{
	protected Integer largura = 1600;
	protected Integer altura = 900;

	public void limpaTela( )
	{
		revalidate( );
		repaint( );
		setLayout( null );
		setBackground( new Color( 232, 228, 20 ) );
	}

}
