package me.Magic_Mat.PvE;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class PvE extends JavaPlugin implements Listener {

	public final Logger logger = Logger.getLogger("Minecraft");
	public int number = 10;

	@Override
	public void onDisable() {
		PluginDescriptionFile pdffile = this.getDescription();
		this.logger.info(pdffile.getName() + " has been Disabled!");
	}

	@Override
	public void onEnable() {
		PluginDescriptionFile pdffile = this.getDescription();
		this.logger.info(pdffile.getName() + " Version " + pdffile.getVersion()
				+ " has been Enabled!");

	}

	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {

		ScoreboardManager manager = Bukkit.getScoreboardManager();
		final Scoreboard board = manager.getNewScoreboard();
		Objective objective = board.registerNewObjective("Points",
				"totalKillCount");

		objective.setDisplaySlot(DisplaySlot.SIDEBAR);

		objective.setDisplayName(ChatColor.GREEN + "Points");

		if (commandLabel.equalsIgnoreCase("start")) {

			if (args[0] == null) {
				Player player = (Player) sender;
				player.sendMessage(ChatColor.RED
						+ "To little args! Usage: /start <player>");
			} else {
				
				
				

				final Player player = getServer().getPlayer(args[0]);
				
				
				
				
				

				
				
				

				this.getServer().getScheduler()
						.scheduleSyncRepeatingTask(this, new Runnable() {
							public void run() {
								if (number != -1) {
									if (number != 0) {
										Bukkit.broadcastMessage(ChatColor.AQUA
												+ "Game Starting in "
												+ ChatColor.GREEN + number
												+ ChatColor.AQUA + " seconds!");
										number--;
									} else {
										Bukkit.broadcastMessage(ChatColor.BLUE
												+ "Game Starting!");
										number--;
										getServer().getScheduler().cancelAllTasks();

										player.performCommand("w1");
										
										
									}
								}

							}

						}, 0L, 20L);


				
				
				
				
				
				
			}

		}else if (commandLabel.equalsIgnoreCase("w1")) {
		
			Player player = (Player) sender;
			
			World world = player.getWorld();
			final Location spawn = new Location(world, 937.5, 67, 957.5);

			
			ItemStack head = new ItemStack(Material.LEATHER_HELMET);
			head.addUnsafeEnchantment(Enchantment.DURABILITY, 100);
			
			ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
			chest.addUnsafeEnchantment(Enchantment.DURABILITY, 100);
			
			ItemStack legs = new ItemStack(Material.LEATHER_LEGGINGS);
			legs.addUnsafeEnchantment(Enchantment.DURABILITY, 100);
			
			ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
			boots.addUnsafeEnchantment(Enchantment.DURABILITY, 100);
			
			ItemStack sword = new ItemStack(Material.STONE_SWORD);
			sword.addUnsafeEnchantment(Enchantment.DURABILITY, 100);
			
			ItemStack bow = new ItemStack(Material.BOW);
			bow.addUnsafeEnchantment(Enchantment.DURABILITY, 100);
			bow.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);

			Location sp1 = new Location(world, 927, 63, 940);
			Location sp2 = new Location(world, 955, 67, 953);
			Location sp3 = new Location(world, 933, 65, 967);
			Location sp4 = new Location(world, 942, 69, 975);
			
		
		player.teleport(spawn);
		
		
		player.getInventory().clear();
		
		player.setGameMode(GameMode.ADVENTURE);

		
		player.getInventory().setHelmet(head);
		player.getInventory().setChestplate(chest);
		player.getInventory().setLeggings(legs);
		player.getInventory().setBoots(boots);
		
		player.getInventory().addItem(sword);
		player.getInventory().addItem(bow);
		player.getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 16));
		player.getInventory().addItem(new ItemStack(Material.ARROW, 1));
		
		
		player.setScoreboard(board);
		
		world.spawnEntity(sp1, EntityType.ZOMBIE);
		world.spawnEntity(sp1, EntityType.ZOMBIE);
		world.spawnEntity(sp1, EntityType.ZOMBIE);
		world.spawnEntity(sp1, EntityType.ZOMBIE);
		
		world.spawnEntity(sp2, EntityType.ZOMBIE);
		world.spawnEntity(sp2, EntityType.ZOMBIE);
		world.spawnEntity(sp2, EntityType.ZOMBIE);
		world.spawnEntity(sp2, EntityType.ZOMBIE);
		
		world.spawnEntity(sp3, EntityType.ZOMBIE);
		world.spawnEntity(sp3, EntityType.ZOMBIE);
		world.spawnEntity(sp3, EntityType.ZOMBIE);
		world.spawnEntity(sp3, EntityType.ZOMBIE);
		
		world.spawnEntity(sp4, EntityType.ZOMBIE);
		world.spawnEntity(sp4, EntityType.ZOMBIE);
		world.spawnEntity(sp4, EntityType.ZOMBIE);
		world.spawnEntity(sp4, EntityType.ZOMBIE);

		return true;

	}
		return false;

}
	
}
