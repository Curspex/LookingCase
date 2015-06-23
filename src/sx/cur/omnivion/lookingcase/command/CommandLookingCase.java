package sx.cur.omnivion.lookingcase.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import sx.cur.omnivion.lookingcase.LookingCase;
import sx.cur.omnivion.lookingcase.lang.Meta;
import sx.cur.omnivion.lookingcase.lang.TL;

public class CommandLookingCase implements CommandExecutor {


	private final LookingCase i;
	public CommandLookingCase(LookingCase i)
	{
		this.i = i;
	}


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if (!(sender instanceof Player))
		{
			sender.sendMessage(TL.NOT_PLAYER.toString());
			return true;
		}

		if (args.length > 0 && args[0].equalsIgnoreCase("save"))
		{
			i.getConfigRegistrar().getData().save();
			sender.sendMessage("SAVED");
			return true;
		}

		final Player player = (Player) sender;
		if (!player.hasMetadata(Meta.SELECTION.toString()))
		{
			player.setMetadata(Meta.SELECTION.toString(), new FixedMetadataValue(i, true));
			sender.sendMessage(TL.SELECTOR_ENABLED.toString());
		}
		else
		{
			player.removeMetadata(Meta.SELECTION.toString(), i);
			sender.sendMessage(TL.SELECTOR_DISABLED.toString());
		}

		return true;
	}

	

}