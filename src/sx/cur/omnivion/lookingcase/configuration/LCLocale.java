package sx.cur.omnivion.lookingcase.configuration;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;

import sx.cur.omnivion.lookingcase.LookingCase;
import sx.cur.omnivion.lookingcase.lang.TL;

public class LCLocale extends LCConfiguration {


	public LCLocale(LookingCase i, String fileName)
	{
		super(i, fileName);
	}

	@Override
	protected void populate()
	{
		this.tls = new HashMap<TL.Type, String>();
		this.addMessage(TL.Type.NOT_PLAYER, super.config.getString("notPlayer"));
		this.addMessage(TL.Type.SELECTOR_ENABLED, super.config.getString("enabledSelector"));
		this.addMessage(TL.Type.SELECTOR_DISABLED, super.config.getString("disabledSelector"));
		this.addMessage(TL.Type.ADDED_CONTAINER, super.config.getString("addedContainer"));
		this.addMessage(TL.Type.REMOVED_CONTAINER, super.config.getString("removedContainer"));
	}

	private final String format(String string)
	{
		return ChatColor.translateAlternateColorCodes('&', string).replace("<n>", "\n");
	}

	private Map<TL.Type, String> tls;
	public final String getMessage(TL.Type tl) { return this.tls.get(tl); }
	public void addMessage(TL.Type tl, String message) { this.tls.put(tl, this.format(message)); }


}