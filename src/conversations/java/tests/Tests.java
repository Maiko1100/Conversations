//package tests;
//
//import android.content.Context;
//import android.media.MediaRecorder;
//import android.os.Environment;
//import org.junit.Test;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import eu.siacs.conversations.Config;
//import eu.siacs.conversations.entities.Account;
//import eu.siacs.conversations.entities.Bookmark;
//import eu.siacs.conversations.entities.Contact;
//import eu.siacs.conversations.entities.Conversation;
//import eu.siacs.conversations.entities.Message;
//import eu.siacs.conversations.generator.MessageGenerator;
//import eu.siacs.conversations.services.NotificationService;
//import eu.siacs.conversations.services.XmppConnectionService;
//import eu.siacs.conversations.ui.RecordingActivity;
//import eu.siacs.conversations.xmpp.stanzas.MessagePacket;
//import rocks.xmpp.addr.Jid;
//
//import static org.junit.Assert.*;
//import static org.junit.Assert.assertTrue;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//public class Tests {
//    private Contact contact;
//    @Mock
//    private XmppConnectionService xmppConnectionService;
//
//    @Mock
//    private Environment enviroment;
////    private Context context = ApplicationProvider.getApplicationContext();
//
//
//
////    @Test
////    public void shouldCreateMessagePacket() {
////        // Arrange
////        MessageGenerator messageGenerator = new MessageGenerator(xmppConnectionService);
////
////        Jid senderJit = Jid.of("pieter", Config.MAGIC_CREATE_DOMAIN, null);
////        Jid receiverJit = Jid.of("peter", Config.MAGIC_CREATE_DOMAIN, null);
////        String password = "password";
////        Account sendAccount = new Account(senderJit, password);
////        Account receiveAccount = new Account(receiverJit, password);
////
////        MessagePacket assertPacket = new MessagePacket();
////        assertPacket.setFrom(sendAccount.getJid());
////        assertPacket.setTo(receiveAccount.getJid());
////
////        // Act
////        MessagePacket createdPacket = messageGenerator.received(sendAccount, receiveAccount.getJid(), "randomId");
////
////        // Assert
////        assertSame(createdPacket.getFrom(), assertPacket.getFrom());
////        assertSame(createdPacket.getTo(), assertPacket.getTo());
////
////    }
//
////    @Test
////    public void shouldInviteForConversation() {
////        // Arrange
////        Jid senderJit = Jid.of("pieter", Config.MAGIC_CREATE_DOMAIN, null);
////        Jid receiverJit = Jid.of("peter", Config.MAGIC_CREATE_DOMAIN, null);
////        String password = "password";
////        Account sendAccount = new Account(senderJit, password);
////        Account receiveAccount = new Account(receiverJit, password);
////
////
////        Conversation conversation = new Conversation("testConversation", sendAccount, receiveAccount.getJid(),
////                Conversation.MODE_SINGLE);
////        MessageGenerator messageGenerator = new MessageGenerator(xmppConnectionService);
////
////        MessagePacket assertPacket = new MessagePacket();
////        assertPacket.setFrom(sendAccount.getJid());
////        assertPacket.setTo(receiveAccount.getJid());
////
////        // Act
////        MessagePacket createdPacket = messageGenerator.invite(conversation, receiveAccount.getJid());
////
////        // Assert
////        assertSame(createdPacket.getFrom(), assertPacket.getFrom());
////        assertSame(createdPacket.getTo(), assertPacket.getTo());
////
////    }
//
//    @Test
//    public void shouldNotDisplaySnoozeAction() {
//        // Arrange
//        Jid senderJit = Jid.of("pieter", Config.MAGIC_CREATE_DOMAIN, null);
//        Jid receiverJit = Jid.of("peter", Config.MAGIC_CREATE_DOMAIN, null);
//        String password = "password";
//        Account sendAccount = new Account(senderJit, password);
//        Account receiveAccount = new Account(receiverJit, password);
//        Conversation conversation = new Conversation("testConversation", sendAccount, receiveAccount.getJid(),
//                Conversation.MODE_SINGLE);
//
//        //Act
//        Message message = new Message(conversation, "Hekkie", Message.ENCRYPTION_NONE);
//        List<Message> messageList= new ArrayList<>();
//        messageList.add(message);
//        boolean shouldDisplaySnooze = NotificationService.displaySnoozeAction(messageList);
//
//        //Assert
//        assertFalse(shouldDisplaySnooze);
//    }
//
//    @Test
//    public void shouldDisplaySnoozeAction() {
//        // Arrange
//        Jid senderJit = Jid.of("pieter", Config.MAGIC_CREATE_DOMAIN, null);
//        Jid receiverJit = Jid.of("peter", Config.MAGIC_CREATE_DOMAIN, null);
//        String password = "password";
//        Account sendAccount = new Account(senderJit, password);
//        Account receiveAccount = new Account(receiverJit, password);
//        Conversation conversation = new Conversation("testConversation", sendAccount, receiveAccount.getJid(),
//                Conversation.MODE_SINGLE);
//
//
//        Message message = new Message(conversation, "Hekkie", Message.ENCRYPTION_NONE);
//        Message message2 = new Message(conversation, "Hekkie", Message.ENCRYPTION_NONE);
//        Message message3 = new Message(conversation, "Hekkie", Message.ENCRYPTION_NONE);
//        message.setStatus(Message.STATUS_RECEIVED);
//        message2.setStatus(Message.STATUS_RECEIVED);
//        message3.setStatus(Message.STATUS_RECEIVED);
//        List<Message> messageList= new ArrayList<>();
//        messageList.add(message);
//        messageList.add(message2);
//        messageList.add(message3);
//
//        //Act
//        boolean shouldDisplaySnooze = NotificationService.displaySnoozeAction(messageList);
//
//        //Assert
//        assertTrue(shouldDisplaySnooze);
//    }
//
//    @Test
//    public void shouldStartRecording() {
//        // Arrange
//        RecordingActivity recordingActivity = mock(RecordingActivity.class);
//        // Act
//        boolean startedRecording = recordingActivity.startRecording();
//        //Assert
//        assertFalse(startedRecording);
//    }
//
//    @Test
//    public void shouldMarkAsReadIfHasDirectReply() {
//        // Arrange
//        XmppConnectionService mock = mock(XmppConnectionService.class);
//        Conversation conversationMock = mock(Conversation.class);
//        when(mock.markRead(conversationMock, false))
//                .thenReturn(true);
//        NotificationService notificationService = new NotificationService(mock);
//
//        Message message = new Message(conversationMock, "Hekkie", Message.ENCRYPTION_NONE);
//        Message message2 = new Message(conversationMock, "Hekkie", Message.ENCRYPTION_NONE);
//        Message message3 = new Message(conversationMock, "Hekkie", Message.ENCRYPTION_NONE);
//        message.setStatus(Message.STATUS_SEND);
//        message2.setStatus(Message.STATUS_SEND);
//        message3.setStatus(Message.STATUS_SEND);
//        ArrayList<Message> messageList= new ArrayList<>();
//        messageList.add(message);
//        messageList.add(message2);
//        messageList.add(message3);
//
//        // Act
//        notificationService.markAsReadIfHasDirectReply(messageList);
//
//        // Assert
//        verify(mock, times(1)).updateConversationUi();
//    }
//
//    @Test
//    public void shouldNotMarkAsReadIfHasDirectReply() {
//        // Arrange
//        XmppConnectionService mock = mock(XmppConnectionService.class);
//        Conversation conversationMock = mock(Conversation.class);
//        when(mock.markRead(conversationMock, false))
//                .thenReturn(true);
//        NotificationService notificationService = new NotificationService(mock);
//
//        Message message = new Message(conversationMock, "Hekkie", Message.ENCRYPTION_NONE);
//        Message message2 = new Message(conversationMock, "Hekkie", Message.ENCRYPTION_NONE);
//        Message message3 = new Message(conversationMock, "Hekkie", Message.ENCRYPTION_NONE);
//        message.setStatus(Message.STATUS_RECEIVED);
//        message2.setStatus(Message.STATUS_RECEIVED);
//        message3.setStatus(Message.STATUS_RECEIVED);
//        ArrayList<Message> messageList= new ArrayList<>();
//        messageList.add(message);
//        messageList.add(message2);
//        messageList.add(message3);
//
//        // Act
//        notificationService.markAsReadIfHasDirectReply(messageList);
//
//        // Assert
//        verify(mock, times(0)).updateConversationUi();
//    }
//
////    @Test
////    public void shouldReturnLocationMessage() {
////        // Arrange
////        XmppConnectionService mock = mock(XmppConnectionService.class);
////        NotificationService notificationService = new NotificationService(mock);
////        Message message = mock(Message.class);
////        Message message2 = mock(Message.class);
////        Message message3 = mock(Message.class);
////        when(message.isGeoUri()).thenReturn(false);
////        when(message2.isGeoUri()).thenReturn(false);
////        when(message3.isGeoUri()).thenReturn(true);
////        ArrayList<Message> messageList= new ArrayList<>();
////        messageList.add(message);
////        messageList.add(message2);
////        messageList.add(message3);
////
////        // Act
////        Message locationMessage = notificationService.getFirstLocationMessage(messageList);
////
////        // Assert
////        assertEquals(message3, locationMessage);
////    }
//
//    @Test
//    public void shouldNotReturnLocationMessage() {
//        // Arrange
//        XmppConnectionService mock = mock(XmppConnectionService.class);
//        NotificationService notificationService = new NotificationService(mock);
//        Message message = mock(Message.class);
//        Message message2 = mock(Message.class);
//        Message message3 = mock(Message.class);
//        when(message.isGeoUri()).thenReturn(false);
//        when(message2.isGeoUri()).thenReturn(false);
//        when(message3.isGeoUri()).thenReturn(false);
//        ArrayList<Message> messageList= new ArrayList<>();
//        messageList.add(message);
//        messageList.add(message2);
//        messageList.add(message3);
//
//        // Act
//        Message locationMessage = notificationService.getFirstLocationMessage(messageList);
//
//        // Assert
//        assertEquals(null, locationMessage);
//    }
//
//
//    }