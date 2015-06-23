package sx.cur.omnivion.lookingcase.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class LocationUtil {


	public static String locationToString(final Location location)
	{
		final StringBuilder builder = new StringBuilder();
		final String br = ",";
		builder.append(location.getWorld().getName() + br);
		builder.append(location.getX() + br);
		builder.append(location.getY() + br);
		builder.append(location.getZ());
		return builder.toString();
	}
	
	public static Location locationFromString(final String string)
	{
		final String[] stringParts = string.split(",");
		if (stringParts.length < 4) return null;
		Location location = null;

		try
		{
			World world = Bukkit.getWorld(stringParts[0]);
			if (world == null) world = Bukkit.getWorlds().get(0);

			double x, y, z;
			x = Double.parseDouble(stringParts[1]);
			y = Double.parseDouble(stringParts[2]);
			z = Double.parseDouble(stringParts[3]);

			location = new Location(world, x, y, z);
		}
		catch (Exception exception) { exception.printStackTrace(); location = null; }

		return location;
	}


}