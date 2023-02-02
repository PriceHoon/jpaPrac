package jpa.pricehoon.thread;

import jpa.pricehoon.channel.Channel;
import jpa.pricehoon.channel.ChannelRepository;
import jpa.pricehoon.mention.Mention;
import jpa.pricehoon.user.User;
import jpa.pricehoon.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class ThreadServiceImplTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ThreadService threadService;

    @Autowired
    ChannelRepository channelRepository;

    @Test
    void getMentionedThreadList() {

        //given

        var newUser = User.builder().username("new").password("1").build();
        var savedUser = userRepository.save(newUser);
        var newThread = Thread.builder().message("message").build();
        newThread.addMention(newUser);
        threadService.insert(newThread);

        var newThread2 = Thread.builder().message("message2").build();
        newThread2.addMention(newUser);
        threadService.insert(newThread2);
        //when

        var mentionedThreads = savedUser.getMentions().stream().map(Mention::getThread).toList();
        //var mentionedThreads = threadService.getMentionedThreadList(savedUser);

        //then

        assert mentionedThreads.containsAll(List.of(newThread,newThread2));
    }

    @Test
    void getNotEmptyThreadList() {

        //given
        var newChannel = Channel.builder().name("c1").type(Channel.Type.PUBLIC).build();
        var savedChannel = channelRepository.save(newChannel);
        var newUser = User.builder().username("new").password("1").build();
        var savedUser = userRepository.save(newUser);
        var newThread = Thread.builder().message("message").build();
        newThread.setChannel(savedChannel);
        threadService.insert(newThread);

        var newThread2 = Thread.builder().message("").build();
        newThread2.setChannel(savedChannel);
        threadService.insert(newThread2);


        //when

        var notEmptyThreads = threadService.selectNotEmptyThreads(savedChannel);
        //var mentionedThreads = threadService.getMentionedThreadList(savedUser);

        //then

        assert !notEmptyThreads.contains(newThread2);
    }
}