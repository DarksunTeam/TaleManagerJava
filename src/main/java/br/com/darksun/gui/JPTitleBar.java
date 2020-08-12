package br.com.darksun.gui;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

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
	private Color color = new Color( 102, 61, 33 );
	private JLabel imgMinimize = new JLabel( "" );
	private JLabel imgMaximize = new JLabel( "" );
	private JLabel imgResize = new JLabel( "" );
	private JLabel imgClose = new JLabel( "" );

	public JPTitleBar( final JFrame frame )
	{
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

		this.titleArea.addMouseListener( getMouseListenerExtendsTitle( frame ) );
		this.minimizeButton.addMouseListener( getMouseListenerMinimize( frame, minimizeButton ) );
		this.maximizeButton.addMouseListener( getMouseListenerMaximize( frame, this.maximizeButton ) );
		this.CloseButton.addMouseListener( getMouseListenerClose( this.CloseButton ) );

		this.minimizeButton.add( imgMinimize );
		this.maximizeButton.add( imgMaximize );
		this.CloseButton.add( imgClose );

		this.add( minimizeButton );
		this.add( maximizeButton );
		this.add( CloseButton );
		this.add( titleArea );

		frame.repaint( );

		frame.addComponentListener( new ComponentAdapter( )
		{
			@Override
			public void componentResized( ComponentEvent e )
			{
				width = ( frame.getBounds( ).width - 200 );
				setBounds( 200, 0, width, 30 );

				minimizeButton.setBounds( width - ( 30 * 3 ), 0, 30, 30 );
				maximizeButton.setBounds( width - ( 30 * 2 ), 0, 30, 30 );
				CloseButton.setBounds( width - ( 30 * 1 ), 0, 30, 30 );
				titleArea.setBounds( 0, 0, width - ( 30 * 3 ), 30 );

				setBackground( new Color( 102, 61, 33 ) );
			}
		} );

		frame.addWindowStateListener( new WindowStateListener( )
		{
			public void windowStateChanged( WindowEvent e )
			{
				if ( ( e.getNewState( ) & Frame.MAXIMIZED_BOTH ) == Frame.MAXIMIZED_BOTH )
				{
					maximizeButton.remove( imgMaximize );
					maximizeButton.add( imgResize );
					maximizeButton.setToolTipText( "Rest. Tamanho" );
				} else if ( ( e.getNewState( ) & Frame.MAXIMIZED_BOTH ) != Frame.MAXIMIZED_BOTH )
				{
					maximizeButton.remove( imgResize );
					maximizeButton.add( imgMaximize );
					maximizeButton.setToolTipText( "Maximizar" );
				}
				maximizeButton.repaint( );
			}
		} );
	}

	private static MouseListener getMouseListenerExtendsTitle( final JFrame frame )
	{
		return new MouseAdapter( )
		{
			@Override
			public void mouseClicked( MouseEvent e )
			{
				if ( e.getClickCount( ) == 2 )
				{
					if ( frame.getExtendedState( ) != JFrame.MAXIMIZED_BOTH )
					{
						( ( JFPrincipal ) frame ).maximize( );
					} else
					{
						( ( JFPrincipal ) frame ).resize( );
					}
				}
			}
		};
	}

	private static MouseListener getMouseListenerMinimize( final JFrame frame, final JPanel button )
	{
		return new MouseAdapter( )
		{
			@Override
			public void mouseClicked( MouseEvent e )
			{
				( ( JFPrincipal ) frame ).minimize( );
			}

			@Override
			public void mouseEntered( MouseEvent e )
			{
				button.setBackground( new Color( 72, 31, 3 ) );
			}

			@Override
			public void mouseExited( MouseEvent e )
			{
				button.setBackground( new Color( 102, 61, 33 ) );
			}
		};
	}

	private static MouseListener getMouseListenerMaximize( final JFrame frame, final JPanel button )
	{
		return new MouseAdapter( )
		{
			@Override
			public void mouseClicked( MouseEvent e )
			{
				if ( frame.getExtendedState( ) != JFrame.MAXIMIZED_BOTH )
				{
					( ( JFPrincipal ) frame ).maximize( );
				} else
				{
					( ( JFPrincipal ) frame ).resize( );
					;
				}
			}

			@Override
			public void mouseEntered( MouseEvent e )
			{
				button.setBackground( new Color( 72, 31, 3 ) );
			}

			@Override
			public void mouseExited( MouseEvent e )
			{
				button.setBackground( new Color( 102, 61, 33 ) );
			}
		};
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
				button.setBackground( new Color( 102, 61, 33 ) );
			}
		};
	}
}
