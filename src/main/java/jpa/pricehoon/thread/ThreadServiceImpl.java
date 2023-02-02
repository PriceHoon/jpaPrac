package jpa.pricehoon.thread;

import com.mysema.commons.lang.IteratorAdapter;
import jpa.pricehoon.channel.Channel;
import jpa.pricehoon.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service

public class ThreadServiceImpl implements ThreadService{


    @Autowired
    ThreadRepository threadRepository;

    @Override
    public List<Thread> selectNotEmptyThreads(Channel channel) {

        var thread = QThread.thread;

        //메세지가 비어있지 않은 헤당 채널의 스레드 목록
        var predicate = thread.channel.eq(channel).and(thread.message.isNotEmpty());


       var threads = threadRepository.findAll(predicate);
        return IteratorAdapter.asList(threads.iterator());
    }

    @Override
    public Thread insert(Thread thread) {

        return threadRepository.save(thread);
    }
}
