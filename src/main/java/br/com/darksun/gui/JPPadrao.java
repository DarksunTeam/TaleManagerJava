package br.com.darksun.gui;

import java.awt.Color;

import javax.swing.JPanel;

public abstract class JPPadrao extends JPanel
{
	protected Integer width = 1400;
	protected Integer height = 870;

	public void limpaTela( )
	{
		revalidate( );
		repaint( );
		setLayout( null );
		setBackground( new Color( 232, 228, 20 ) );
	}

}
