package jpa.pricehoon.userChannel;

import jpa.pricehoon.common.PageDTO;
import jpa.pricehoon.channel.Channel;
import jpa.pricehoon.channel.ChannelRepository;
import jpa.pricehoon.user.User;
import jpa.pricehoon.user.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
@Rollback(value = false)
class UserChannelRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private UserChannelRepository userChannelRepository;

    @Test
    void userJoinChannel() {

        var newChannel = Channel.builder().name("new-group2").build();
        var newUser = User.builder().username("new-user").password("new-pass").build();

        var newUserChannel = newChannel.joinUser(newUser);


        //extends JpaRespository<>로 바꿔줌.

//        // when
//        var savedChannel = channelRepository.insertChannel(newChannel);
//        var savedUser = userRepository.insertUser(newUser);
//        var savedUserChannel = userChannelRepository.insertUserChannel(newUserChannel);
//
//
//        // then
//        var foundChannel = channelRepository.selectChannel(savedChannel.getId());
//        assert foundChannel.getUserChannels().stream()
//                .map(UserChannel::getChannel)
//                .map(Channel::getName)
//                .anyMatch(name -> name.equals(newChannel.getName()));

    }

    @Test
    void userJoinChannelWithCascadeTest () {

        var newChannel = Channel.builder().name("new-group2").build();
        var newUser = User.builder().username("new-user").password("new-pass").build();

        var newUserChannel = newChannel.joinUser(newUser);

        //extends JpaRespository<>로 바꿔줌.


        // when
        var savedChannel = channelRepository.save(newChannel);
        var savedUser = userRepository.save(newUser);
        var savedUserChannel = userChannelRepository.insertUserChannel(newUserChannel);


//        // then
        var foundChannel = channelRepository.findById(savedChannel.getId());
        assert foundChannel.get().getUserChannels().stream()
                .map(UserChannel::getChannel)
                .map(Channel::getName)
                .anyMatch(name -> name.equals(newChannel.getName()));

    }

    @Test
    @DisplayName("UserRepository페이징 테스트")
    void userPasswordFieldSortingTest(){


        //given
        var newUser1 = User.builder().username("new_user").password("new-pass1").build();
        var newUser2 = User.builder().username("new_user").password("new-pass2").build();

        userRepository.save(newUser1);
        userRepository.save(newUser2);


        //when
        var users = userRepository.findByUsername("new_user", Sort.by("user_password"));

        assert users.get(0).getPassword().equals(newUser1.getPassword());



        users = userRepository.findByUsername("new_user", Sort.by("user_password").descending());


        var newUser3 = User.builder().username("new_user").password("3").build();
        userRepository.save(newUser3);

        //특정 필드 값의 길이로 정렬하는 부
        users = userRepository.findByUsernameWithLength("new_user", JpaSort.unsafe("LENGTH(password)"));

        assert users.get(0).getPassword().equals(newUser3.getPassword());

    }

    @Test
    @DisplayName("PageDTO Test")
    void PageDtoTest(){

        //given
        var newUser1 = User.builder().username("new_user").password("new-pass1").build();
        var newUser2 = User.builder().username("new_user").password("new-pass2").build();
        var newUser3 = User.builder().username("new_user").password("new-pass3").build();

        userRepository.save(newUser1);
        userRepository.save(newUser2);

        var pageDTO = new PageDTO(1,2,"password");
        //when

        var page = userRepository.findAll(pageDTO.toPageable());

        //then

        assert page.getContent().size() == 2;
    }
}