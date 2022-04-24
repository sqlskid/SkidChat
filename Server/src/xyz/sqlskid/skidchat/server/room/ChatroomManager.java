package xyz.sqlskid.skidchat.server.room;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChatroomManager {

    private final List<Chatroom> chatrooms = new ArrayList<>();

    public ChatroomManager()
    {
        addChatroom(new Chatroom("general",false));
    }

    public Chatroom getChatroomByOwner(UUID uuid){
        for (Chatroom chatroom: chatrooms){
            if(chatroom.owner != null && chatroom.owner.equals(uuid)) {
                return chatroom;
            }
        }
        return null;
    }

    public Chatroom getChatroom(String name){
        for (Chatroom chatroom: chatrooms){
            if(chatroom.getName().equalsIgnoreCase(name)) {
                return chatroom;
            }
        }
        return null;
    }

    public List<Chatroom> getChatrooms() {
        return chatrooms;
    }

    public void addChatroom(Chatroom chatroom){
        if(getChatroom(chatroom.getName()) == null)
            this.chatrooms.add(chatroom);
    }

    public void removeChatroom(Chatroom chatroomByOwner) {
        chatrooms.remove(chatroomByOwner);
    }
}
