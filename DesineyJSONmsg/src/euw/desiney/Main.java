package euw.desiney;

import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.IChatBaseComponent;
import net.minecraft.server.v1_8_R1.PacketPlayOutChat;

import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	public void onEnable(){
		loadConfig();
		this.getServer().getPluginManager().registerEvents(this, this);
	}
	
	private void loadConfig(){
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
	@EventHandler
	public void interact(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		IChatBaseComponent comp = ChatSerializer.a("{\"text\":\"hello\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":\"§6DesineyTest\"}}");
		PacketPlayOutChat chat = new PacketPlayOutChat(comp);
		((CraftPlayer)player).getHandle().playerConnection.sendPacket(chat);
	}

}
