package sx.cur.omnivion.lookingcase.configuration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import sx.cur.omnivion.lookingcase.LookingCase;

public abstract class LCConfiguration {


	protected final LookingCase i;
	protected final File file;
	protected FileConfiguration config;


	protected LCConfiguration(LookingCase i, String fileName)
	{
		this.i = i;

		File folder = this.i.getDataFolder();
		if (!folder.isDirectory())
		{
			folder.mkdirs();
		}

		this.file = new File(this.i.getDataFolder(), fileName);

		if (!file.exists())
		{
			final InputStream input = i.getClass().getResourceAsStream("/resources/" + fileName);

			try (final OutputStream output = new FileOutputStream(file))
			{
				int read;
				byte[] bytes = new byte[1024];

				while ((read = input.read(bytes)) != -1)
				{
					output.write(bytes, 0, read);
				}

				output.close();
			}
			catch (Exception exception) { exception.printStackTrace(); }
		}

		this.cns();
	}

	protected void cns()
	{
		this.config = YamlConfiguration.loadConfiguration(this.file);
		config.options().copyDefaults(true);
		try
		{
			config.save(file);
		}
		catch (IOException exception) { exception.printStackTrace(); }
		this.populate();
	}

	protected void reload()
	{
		//i.reloadConfig();
		this.cns();
	}

	protected abstract void populate();


}