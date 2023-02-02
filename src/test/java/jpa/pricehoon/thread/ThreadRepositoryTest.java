package jpa.pricehoon.thread;

import jpa.pricehoon.channel.Channel;
import jpa.pricehoon.channel.ChannelRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class ThreadRepositoryTest {


    @Autowired
    private ThreadRepository threadRepository;

    @Autowired
    private ChannelRepository channelRepository;
    @Test
    void insertThread() {

        // given
        var newChannel = Channel.builder().name("new-channel").build();
        var newThread = Thread.builder().message("new-message").build();
        var newThread2 = Thread.builder().message("new-message2").build();

        newThread.setChannel(newChannel);//연관관계가 있으니까...
        newThread2.setChannel(newChannel);//연관관계가 있으니까...


        //extends JpaRepository<>변경 전
        // when
//        var savedChannel = channelRepository.insertChannel(newChannel);
//        var savedThread = threadRepository.insertThread(newThread);
//        var savedThread2 = threadRepository.insertThread(newThread2);
//
//        // then
//        // var foundUser = threadRepository.selectThread(savedThread.getId());//영속성 컨텍스트에서 조회하기 때문에 Select 쿼리 안나감
//        //assert foundUser.getId().equals(savedThread.getId());
//
//        var foundChannel = channelRepository.selectChannel(savedChannel.getId());
//        assert foundChannel.getThreads().containsAll(Set.of(savedThread,savedThread2));

    }

    @Test
    void deleteThreadByOrphanRemovalTest() {

        // given
        var newChannel = Channel.builder().name("new-channel").build();
        var newThread = Thread.builder().message("new-message").build();
        var newThread2 = Thread.builder().message("new-message2").build();

        newThread.setChannel(newChannel);//연관관계가 있으니까...
        newThread2.setChannel(newChannel);//연관관계가 있으니까...



        //extends JpaRepository<>변경 전
//        // when
//        var savedChannel = channelRepository.insertChannel(newChannel);
//        var savedThread = threadRepository.insertThread(newThread);
//        var savedThread2 = threadRepository.insertThread(newThread2);
//
//        // then
//        // var foundUser = threadRepository.selectThread(savedThread.getId());//영속성 컨텍스트에서 조회하기 때문에 Select 쿼리 안나감
//        //assert foundUser.getId().equals(savedThread.getId());
//
//        var foundChannel = channelRepository.selectChannel(savedChannel.getId());
//        foundChannel.getThreads().remove(savedThread); // orphanRemove테스트를 위한 것

    }
}