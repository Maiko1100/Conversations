//package tests;
//
//import android.content.Context;
//import android.os.Environment;
//import org.junit.Test;
//import org.mockito.Mock;
//import org.robolectric.shadows.ShadowEnvironment;
//
//import eu.siacs.conversations.Config;
//import eu.siacs.conversations.entities.Account;
//import eu.siacs.conversations.entities.Contact;
//import eu.siacs.conversations.entities.Conversation;
//import eu.siacs.conversations.generator.MessageGenerator;
//import eu.siacs.conversations.services.XmppConnectionService;
//import eu.siacs.conversations.xmpp.stanzas.MessagePacket;
//import rocks.xmpp.addr.Jid;
//
//import static org.junit.Assert.*;
//import static org.junit.Assert.assertTrue;
//
//public class Tests {
//    private Contact contact;
//    @Mock
//    private XmppConnectionService xmppConnectionService;
////    private Context context = ApplicationProvider.getApplicationContext();
//
//    @Test
//    public void testAssertions() {
//        //test data
//        String str1 = new String ("abc");
//        String str2 = new String ("abc");
//        String str3 = null;
//        String str4 = "abc";
//        String str5 = "abc";
//        int val1 = 5;
//        int val2 = 6;
//        String[] expectedArray = {"one", "two", "three"};
//        String[] resultArray =  {"one", "two", "three"};
//
//        //Check that two objects are equal
//        assertEquals(str1, str2);
//
//        //Check that a condition is true
//        assertTrue (val1 < val2);
//
//        //Check that a condition is false
//        assertFalse(val1 > val2);
//
//        //Check that an object isn't null
//        assertNotNull(str1);
//
//        //Check that an object is null
//        assertNull(str3);
//
//        //Check if two object references point to the same object
//        assertSame(str4,str5);
//
//        //Check if two object references not point to the same object
//        assertNotSame(str1,str3);
//
//        //Check whether two arrays are equal to each other.
//        assertArrayEquals(expectedArray, resultArray);
//    }
//
//    @Test
//    public void shouldCreateMessagePacket() {
//        // Arrange
////        ShadowEnvironment.setExternalStorageState(Environment.MEDIA_MOUNTED);
//        MessageGenerator messageGenerator = new MessageGenerator(xmppConnectionService);
//
//        Jid senderJit = Jid.of("pieter", Config.MAGIC_CREATE_DOMAIN, null);
//        Jid receiverJit = Jid.of("peter", Config.MAGIC_CREATE_DOMAIN, null);
//        String password = "password";
//        Account sendAccount = new Account(senderJit, password);
//        Account receiveAccount = new Account(receiverJit, password);
//
//        MessagePacket assertPacket = new MessagePacket();
//        assertPacket.setFrom(sendAccount.getJid());
//        assertPacket.setTo(receiveAccount.getJid());
//
//        // Act
//        MessagePacket createdPacket = messageGenerator.received(sendAccount, receiveAccount.getJid(), "randomId");
//
//        // Assert
//        assertSame(createdPacket.getFrom(), assertPacket.getFrom());
//        assertSame(createdPacket.getTo(), assertPacket.getTo());
//
//    }
//
//    @Test
//    public void shouldInviteForConversation() {
//        // Arrange
//        Jid senderJit = Jid.of("pieter", Config.MAGIC_CREATE_DOMAIN, null);
//        Jid receiverJit = Jid.of("peter", Config.MAGIC_CREATE_DOMAIN, null);
//        String password = "password";
//        Account sendAccount = new Account(senderJit, password);
//        Account receiveAccount = new Account(receiverJit, password);
//
//
//        Conversation conversation2 = new Conversation("testConversation", sendAccount, receiveAccount.getJid(),
//                Conversation.MODE_SINGLE);
//        MessageGenerator messageGenerator = new MessageGenerator(xmppConnectionService);
//
//        MessagePacket assertPacket = new MessagePacket();
//        assertPacket.setFrom(sendAccount.getJid());
//        assertPacket.setTo(receiveAccount.getJid());
//
//        // Act
//        MessagePacket createdPacket = messageGenerator.invite(conversation2, receiveAccount.getJid());
//        System.out.println(createdPacket);
//
//        // Assert
//        assertSame(createdPacket.getFrom(), assertPacket.getFrom());
//        assertSame(createdPacket.getTo(), assertPacket.getTo());
//
//    }
//
//
//}