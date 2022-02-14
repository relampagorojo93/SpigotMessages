package relampagorojo93.LibsCollection.SpigotMessages.NMS.v1_8_R3;

import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.chat.BaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import relampagorojo93.LibsCollection.SpigotMessages.Enums.ChatMessageType;
import relampagorojo93.LibsCollection.SpigotMessages.Instances.TextResult;

public class NMSMessageBuilder extends relampagorojo93.LibsCollection.SpigotMessages.NMS.Base.NMSMessageBuilder {
	
	@SuppressWarnings("deprecation")
	@Override
	public void sendTitle(Player player, boolean color, String title, String subtitle, int fadein, int stay, int fadeout) {
		player.sendTitle(createMessage(color, title).getStrings().get(0), createMessage(color, subtitle).getStrings().get(0));
	}
	
	@Override
	public void sendMessage(CommandSender[] senders, ChatMessageType type, TextResult result) {
		for (CommandSender sender:senders) {
			Player pl = sender instanceof Player ? (Player) sender : null;
			if (pl != null) {
				PacketPlayOutChat message = new PacketPlayOutChat(null, (byte) type.ordinal());
				for (BaseComponent[] components:result.getComponents()) {
					message.components = components;
					((CraftPlayer) pl).getHandle().playerConnection.sendPacket(message);
				}
			}
			else for (String line:result.getStrings()) sender.sendMessage(line);
		}
	}
	
}
