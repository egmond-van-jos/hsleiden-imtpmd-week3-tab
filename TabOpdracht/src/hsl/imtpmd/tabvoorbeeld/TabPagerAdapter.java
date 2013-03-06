package hsl.imtpmd.tabvoorbeeld;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;



/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class TabPagerAdapter extends ...
{
	//we houden een lijst bij met alle fragments (dat zijn de verschillende pagina's)
	private ...;
	
	public TabPagerAdapter( FragmentManager fm, List<Fragment> fragmentList )
	{
		super( fm );
		
		//in de constructor maken we een nieuwe lijst aan, in dit geval een ArrayList
		this.fragmentList = fragmentList;
	}
	
	
	//deze methode wordt door de tab widget aangeroepen als de tabwidget een pagina wil tonen vanuit een index
	@Override
	public Fragment getItem( int index )
	{
		//geef het fragment terug op de index in de lijst
		return ...;
	}

	//deze methode wordt door de tab widget aangeroepen als de tabwidget wil weten hoeveel pagina's er in totaal zijn
	@Override
	public int getCount()
	{
		//geef de grootte terug van de lijst
		return ...;
	}

}
