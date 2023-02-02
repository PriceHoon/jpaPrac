package jpa.pricehoon.thread;

import jpa.pricehoon.channel.Channel;
import jpa.pricehoon.user.User;

import java.util.List;

public interface ThreadService {

    //List<Thread> getMentionedThreadList(User user);

    List<Thread> selectNotEmptyThreads(Channel channel);

    Thread insert(Thread thread);
}
