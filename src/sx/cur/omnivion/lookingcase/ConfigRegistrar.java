package sx.cur.omnivion.lookingcase;

import sx.cur.omnivion.lookingcase.configuration.*;

public class ConfigRegistrar implements IAnnihilate {


	private final LookingCase i;


	public ConfigRegistrar(LookingCase i)
	{
		this.i = i;
	}


	public final void register()
	{
		this.primary = new LCPrimary(i, "config.yml");
		this.locale = new LCLocale(i, "locale.yml");
		this.data = new LCData(i, "cases.yml");
	}

	@Override
	public final void annihilate()
	{
		this.primary = null;
		this.locale = null;
		this.data.save();
		this.data = null;
	}


	private LCPrimary primary;
	public final LCPrimary getConfig() { return this.primary; }

	private LCLocale locale;
	public final LCLocale getLocale() { return this.locale; }

	private LCData data;
	public final LCData getData() { return this.data; }


}