package hsl.imtpmd.tabvoorbeeld;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener
{
	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	TabPagerAdapter tabPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Set up the action bar.
		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		
		
		//we maken onze eigen adapter aan om de fragments aan toe te voegen
		//de adapter is een klasse die data (b.v. de fragments) en
		//de interface (om de fragments te tonen) aan elkaar koppelt
		List<Fragment> fragmentList = ...;
		tabPagerAdapter = new TabPagerAdapter( getSupportFragmentManager(), fragmentList );
		fragmentList.add( new DummyTabFragment() );
		fragmentList.add( ... );
		
		//we moeten ook een viewpager hebben die de pagina's (fragments) op het scherm toont
		//hier koppelen we ook de adapter aan
		mViewPager = (ViewPager) findViewById(R.id.pager);
		...;

		//We kunnen ook swipen, maar de Tabs bovenaan het beeld gaan niet automatisch mee.
		//We moeten de onPageChangeListener instellen van de viewPager
		//als deze listener door middel van swipe wordt aangeroepen verwisselen we de tabs
		mViewPager.setOnPageChangeListener(
			new ViewPager.SimpleOnPageChangeListener()
			{
				@Override
				public void onPageSelected(int position)
				{
					actionBar.setSelectedNavigationItem(position);
				}
			}
		);

		//stel alle tabs in (dit zijn de tabbladen bovenin, niet de pagina's zelf)
		//deze tabs worden verwisseld d.m.v. gebruiker touch en swipe (zie hierboven)
		Tab dummyTab = actionBar.newTab();
		dummyTab.setText( "Dummy Tab" );
		dummyTab.setTabListener( this );
		actionBar.addTab( dummyTab );

		Tab infoTab = ...;
	}


	@Override
	public void onTabSelected( ActionBar.Tab tab, FragmentTransaction fragmentTransaction)
	{
		// When the given tab is selected, switch to the corresponding page in the ViewPager.
		mViewPager.setCurrentItem( tab.getPosition() );
	}

	@Override
	public void onTabUnselected( ActionBar.Tab tab, FragmentTransaction fragmentTransaction)
	{
	}

	@Override
	public void onTabReselected( ActionBar.Tab tab, FragmentTransaction fragmentTransaction)
	{
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
