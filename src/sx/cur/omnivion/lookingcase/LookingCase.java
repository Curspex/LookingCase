package sx.cur.omnivion.lookingcase;

import org.bukkit.Bukkit;
import org.bukkit.event.EventPriority;
import org.bukkit.plugin.java.JavaPlugin;

import sx.cur.omnivion.lookingcase.command.CommandLookingCase;
import sx.cur.omnivion.lookingcase.listener.player.*;

public class LookingCase extends JavaPlugin {


	public static LookingCase i;

	private ConfigRegistrar configRegistrar;
	public ConfigRegistrar getConfigRegistrar() { return i.configRegistrar; }

	private EventRegistrar eventRegistrar;

	@Override
	public void onEnable()
	{
		i = this;

		i.configRegistrar = new ConfigRegistrar(i);
		i.configRegistrar.register();

		i.eventRegistrar = new EventRegistrar(i, Bukkit.getPluginManager(), true, EventPriority.HIGH);
		i.eventRegistrar.registerEvent(new ListenerPlayerInteract(i));
		i.eventRegistrar.registerEvent(new ListenerInventoryOpen(i));
		i.eventRegistrar.registerEvent(new ListenerInventoryModify(i));
		i.eventRegistrar.registerEvent(new ListenerInventoryClose(i));
		if (i.configRegistrar.getConfig().getRemoveOnBreak())
		{
			i.eventRegistrar.registerEvent(new ListenerBlockBreak(i));
		}

		i.getCommand("lookingcase").setExecutor(new CommandLookingCase(i));
	}

	@Override
	public void onDisable()
	{
		i.configRegistrar.annihilate();
		i.configRegistrar = null;

		i.eventRegistrar.annihilate();
		i.eventRegistrar = null;

		i = null;
	}


}