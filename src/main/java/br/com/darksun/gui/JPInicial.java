package br.com.darksun.gui;

import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

public class JPInicial extends JPPadrao
{
	public JPInicial( final JFrame frame )
	{
		this.setBounds( 200, 30, this.width, this.height );
		this.setBackground( new Color( 232, 228, 201 ) );

		frame.repaint( );

		frame.addComponentListener( new ComponentAdapter( )
		{
			@Override
			public void componentResized( ComponentEvent e )
			{

				width = ( frame.getBounds( ).width - 200 );
				height = ( frame.getBounds( ).height - 30 );

				setBounds( 200, 30, frame.getWidth( ), frame.getHeight( ) );
				setBackground( new Color( 232, 228, 201 ) );
			}
		} );
	}
}
