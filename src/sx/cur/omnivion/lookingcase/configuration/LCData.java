package sx.cur.omnivion.lookingcase.configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bukkit.Location;

import sx.cur.omnivion.lookingcase.LookingCase;
import sx.cur.omnivion.lookingcase.util.LocationUtil;

public class LCData extends LCConfiguration {


	public LCData(LookingCase i, String fileName)
	{
		super(i, fileName);
	}

	@Override
	protected void populate()
	{
		this.cases = new HashSet<Location>();
		for (final String locationstr : super.config.getStringList("locations"))
		{
			if (LocationUtil.locationFromString(locationstr) == null) continue;
			this.cases.add(LocationUtil.locationFromString(locationstr));
		}
	}
	
	public void save()
	{
		final List<String> newLocations = new ArrayList<String>();

		for (final Location location : cases)
		{
			newLocations.add(LocationUtil.locationToString(location));
		}

		super.config.set("locations", newLocations);

		try
		{
			super.config.save(super.file);
		}
		catch (IOException exception) { exception.printStackTrace(); }
	}

	private Set<Location> cases;
	public final Set<Location> getCases() { return this.cases; }
	public final void addCase(final Location location) { this.cases.add(location); }


}