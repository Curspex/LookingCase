package sx.cur.omnivion.lookingcase.util;

import org.bukkit.Location;

import sx.cur.omnivion.lookingcase.LookingCase;

public class CaseUtil {


	public static void registerCase(final Location location)
	{
		LookingCase.i.getConfigRegistrar().getData().addCase(location);
	}

	public static void deleteCase(final Location location)
	{
		LookingCase.i.getConfigRegistrar().getData().getCases().remove(location);
	}
	
	public static boolean isCase(final Location location)
	{
		return LookingCase.i.getConfigRegistrar().getData().getCases().contains(location);
	}


}