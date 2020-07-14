package br.com.darksun.gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPTitleBar extends JPanel
{
	private Integer width = 1400;
	private Integer height = 30;
	private JPanel titleArea = new JPanel( );
	private JPanel minimizeButton = new JPanel( );
	private JPanel maximizeButton = new JPanel( );
	private JPanel CloseButton = new JPanel( );
	private Color color = new Color( 92, 51, 23 );

	public JPTitleBar( JFrame frame )
	{
		JLabel imgMinimize = new JLabel( "" );
		JLabel imgMaximize = new JLabel( "" );
		JLabel imgResize = new JLabel( "" );
		JLabel imgClose = new JLabel( "" );

		this.setLayout( null );

		this.setBounds( frame.getBounds( ).width - this.width, 0, this.width, this.height );

		imgMinimize.setBounds( this.width - ( this.height * 3 ) + 5, 5, this.height - 10, this.height - 10 );
		imgMaximize.setBounds( this.width - ( this.height * 2 ) + 5, 5, this.height - 10, this.height - 10 );
		imgResize.setBounds( this.width - ( this.height * 2 ) + 5, 5, this.height - 10, this.height - 10 );
		imgClose.setBounds( this.width - ( this.height * 1 ) + 5, 5, this.height - 10, this.height - 10 );

		ImageIcon iconMinimize = new ImageIcon( getClass( ).getClassLoader( ).getResource( "img/minimize.png" ) );
		ImageIcon iconMaximize = new ImageIcon( getClass( ).getClassLoader( ).getResource( "img/maximize.png" ) );
		ImageIcon iconResize = new ImageIcon( getClass( ).getClassLoader( ).getResource( "img/resize.png" ) );
		ImageIcon iconClose = new ImageIcon( getClass( ).getClassLoader( ).getResource( "img/close.png" ) );

		iconMinimize = new ImageIcon( iconMinimize.getImage( ).getScaledInstance( imgMinimize.getWidth( ),
				imgMinimize.getHeight( ), iconMinimize.getImage( ).SCALE_DEFAULT ) );

		iconMaximize = new ImageIcon( iconMaximize.getImage( ).getScaledInstance( imgMaximize.getWidth( ),
				imgMaximize.getHeight( ), iconMaximize.getImage( ).SCALE_DEFAULT ) );

		iconResize = new ImageIcon( iconResize.getImage( ).getScaledInstance( imgResize.getWidth( ),
				imgResize.getHeight( ), iconResize.getImage( ).SCALE_DEFAULT ) );

		iconClose = new ImageIcon( iconClose.getImage( ).getScaledInstance( imgClose.getWidth( ), imgClose.getHeight( ),
				iconClose.getImage( ).SCALE_DEFAULT ) );

		imgMinimize.setIcon( iconMinimize );
		imgMaximize.setIcon( iconMaximize );
		imgResize.setIcon( iconResize );
		imgClose.setIcon( iconClose );

		this.titleArea.setBounds( 0, 0, this.width - ( this.height * 3 ), this.height );
		this.minimizeButton.setBounds( this.width - ( this.height * 3 ), 0, this.height, this.height );
		this.maximizeButton.setBounds( this.width - ( this.height * 2 ), 0, this.height, this.height );
		this.CloseButton.setBounds( this.width - ( this.height * 1 ), 0, this.height, this.height );

		this.minimizeButton.setToolTipText( "Minimizar" );
		this.maximizeButton.setToolTipText( "Maximizar" );
		this.CloseButton.setToolTipText( "Fechar" );

		this.titleArea.setBackground( this.color );
		this.minimizeButton.setBackground( this.color );
		this.maximizeButton.setBackground( this.color );
		this.CloseButton.setBackground( this.color );

		this.CloseButton.addMouseListener( getMouseListenerClose( this.CloseButton ) );

		this.minimizeButton.add( imgMinimize );
		this.maximizeButton.add( imgMaximize );
		this.CloseButton.add( imgClose );

		this.add( minimizeButton );
		this.add( maximizeButton );
		this.add( CloseButton );
		this.add( titleArea );
	}

	private static MouseListener getMouseListenerClose( final JPanel button )
	{
		return new MouseAdapter( )
		{
			@Override
			public void mouseClicked( MouseEvent e )
			{
				System.exit( 0 );
			}

			@Override
			public void mouseEntered( MouseEvent e )
			{
				button.setBackground( Color.RED );
			}

			@Override
			public void mouseExited( MouseEvent e )
			{
				button.setBackground( new Color( 92, 51, 23 ) );
			}
		};

	}

}
