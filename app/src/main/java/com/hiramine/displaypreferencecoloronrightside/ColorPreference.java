package com.hiramine.displaypreferencecoloronrightside;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;


public class ColorPreference extends DialogPreference implements SeekBar.OnSeekBarChangeListener
{
	private ImageView mImageViewColor;
	private TextView  mTextViewR;
	private TextView  mTextViewG;
	private TextView  mTextViewB;
	private SeekBar   mSeekBarR;
	private SeekBar   mSeekBarG;
	private SeekBar   mSeekBarB;

	public ColorPreference( Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes )
	{
		super( context, attrs, defStyleAttr, defStyleRes );
	}

	public ColorPreference( Context context, AttributeSet attrs, int defStyleAttr )
	{
		super( context, attrs, defStyleAttr );
	}

	public ColorPreference( Context context, AttributeSet attrs )
	{
		super( context, attrs );
	}

	public ColorPreference( Context context )
	{
		super( context );
	}

	public void setColor( int iColor )
	{
		persistInt( iColor );
	}

	public int getColor()
	{
		return getPersistedInt( Color.rgb( 0, 0, 0 ) );
	}

	@Override
	protected View onCreateDialogView()
	{
		setDialogLayoutResource( R.layout.dialog_colorpreference );

		return super.onCreateDialogView();
	}

	@Override
	protected void onBindDialogView( View view )
	{
		super.onBindDialogView( view );

		// プリファレンス値の読み込み
		int iColor = getColor();
		// RBG値の分解
		int iR = Color.red( iColor );
		int iG = Color.green( iColor );
		int iB = Color.blue( iColor );

		// ビューのアイテムの更新
		// （ビューは、onCreateDialogView()で作成される）

		// Image
		mImageViewColor = (ImageView)view.findViewById( R.id.imageview_color );
		mImageViewColor.setBackgroundColor( iColor );

		// Red
		mTextViewR = (TextView)view.findViewById( R.id.textview_r );
		mTextViewR.setText( String.valueOf( iR ) );
		mSeekBarR = (SeekBar)view.findViewById( R.id.seekbar_r );
		mSeekBarR.setProgress( iR );
		mSeekBarR.setOnSeekBarChangeListener( this );
		// シークバーの背景色設定
		GradientDrawable gradientDrawableR = new GradientDrawable();
		gradientDrawableR.mutate();
		gradientDrawableR.setOrientation( GradientDrawable.Orientation.LEFT_RIGHT );
		gradientDrawableR.setColors( new int[]{ Color.BLACK, Color.RED } );
		mSeekBarR.setBackground( gradientDrawableR );

		// Green
		mTextViewG = (TextView)view.findViewById( R.id.textview_g );
		mTextViewG.setText( String.valueOf( iG ) );
		mSeekBarG = (SeekBar)view.findViewById( R.id.seekbar_g );
		mSeekBarG.setProgress( iG );
		mSeekBarG.setOnSeekBarChangeListener( this );
		// シークバーの背景色設定
		GradientDrawable gradientDrawableG = new GradientDrawable();
		gradientDrawableG.mutate();
		gradientDrawableG.setOrientation( GradientDrawable.Orientation.LEFT_RIGHT );
		gradientDrawableG.setColors( new int[]{ Color.BLACK, Color.GREEN } );
		mSeekBarG.setBackground( gradientDrawableG );

		// Blue
		mTextViewB = (TextView)view.findViewById( R.id.textview_b );
		mTextViewB.setText( String.valueOf( iB ) );
		mSeekBarB = (SeekBar)view.findViewById( R.id.seekbar_b );
		mSeekBarB.setProgress( iB );
		mSeekBarB.setOnSeekBarChangeListener( this );
		// シークバーの背景色設定
		GradientDrawable gradientDrawableB = new GradientDrawable();
		gradientDrawableB.mutate();
		gradientDrawableB.setOrientation( GradientDrawable.Orientation.LEFT_RIGHT );
		gradientDrawableB.setColors( new int[]{ Color.BLACK, Color.BLUE } );
		mSeekBarB.setBackground( gradientDrawableB );
	}

	@Override
	protected void onDialogClosed( boolean positiveResult )
	{
		super.onDialogClosed( positiveResult );

		if( positiveResult )
		{
			int iR = mSeekBarR.getProgress();
			int iG = mSeekBarG.getProgress();
			int iB = mSeekBarB.getProgress();
			// RGB値の結合
			int iColor = Color.rgb( iR, iG, iB );

			// プリファレンス値の保存
			setColor( iColor );
		}
	}

	@Override
	public void onProgressChanged( SeekBar seekBar, int progress, boolean fromUser )
	{
		int iR = mSeekBarR.getProgress();
		int iG = mSeekBarG.getProgress();
		int iB = mSeekBarB.getProgress();

		// イメージの更新
		mImageViewColor.setBackgroundColor( Color.rgb( iR, iG, iB ) );
		// テキストの更新
		mTextViewR.setText( String.valueOf( iR ) );
		mTextViewG.setText( String.valueOf( iG ) );
		mTextViewB.setText( String.valueOf( iB ) );
	}

	@Override
	public void onStartTrackingTouch( SeekBar seekBar )
	{
		// 何もなし
	}

	@Override
	public void onStopTrackingTouch( SeekBar seekBar )
	{
		// 何もなし
	}

	// preferences.xmlのandroid:defaultValueで設定したデフォルト値を利用するために必要な処理
	@Override
	protected Object onGetDefaultValue( TypedArray a, int index )
	{
		return a.getString( index );
	}

	// preferences.xmlのandroid:defaultValueで設定したデフォルト値を利用するために必要な処理
	// 書式は、"#RRGGBB"とする。（整数化の方法は、Color.parseColor("#RRGGBB");）
	@Override
	protected void onSetInitialValue( boolean restoreValue, Object defaultValue )
	{
		setColor( restoreValue ? getColor() : Color.parseColor( (String)defaultValue ) );
	}
}

