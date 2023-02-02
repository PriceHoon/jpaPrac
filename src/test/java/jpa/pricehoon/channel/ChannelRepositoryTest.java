package jpa.pricehoon.channel;

import com.querydsl.core.types.Predicate;
import jpa.pricehoon.channel.ChannelRepository;
import jpa.pricehoon.user.User;
import jpa.pricehoon.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Transactional  // 실무에서 사용시 주의해야합니다. (테스트 대상 환경에 영향을 줌)
@Rollback(value = false)
class ChannelRepositoryTest {

    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private UserRepository userRepository;
    @Test
    void insertSelectGroupTest() {
        // given
        var newChannel = Channel.builder().name("new-group2").build();


        //extends JpaRespository<>로 바꿔줌.
//        // when
        var savedChannel = channelRepository.save(newChannel);
//
//        // then
        var foundUser = channelRepository.findById(savedChannel.getId());//영속성 컨텍스트에서 조회하기 때문에 Select 쿼리 안나감
        assert foundUser.get().getId().equals(savedChannel.getId());
    }

    @Test
    void queryDslTest() {
        // given
        var newChannel = Channel.builder().name("sanghoon").build();
        channelRepository.save(newChannel);

        Predicate predicate = QChannel.channel.name.equalsIgnoreCase("SANGHOON");

        // when
        Optional<Channel> optional = channelRepository.findOne(predicate);

        // then
        assert optional.get().getName().equals(newChannel.getName());
    }

    @Test
    void contextHolderLifeCycleTest(){
        var newUser = User.builder().username("new").password("pass").build();
        //var newUser2 = User.builder().username("modified").password("pass").build();
        var savedUser =  userRepository.save(newUser);

        SecurityContext context = SecurityContextHolder.createEmptyContext();
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(newUser,null);
        Authentication authentication = token;
        context.setAuthentication(authentication);
        SecurityContextHolder.setContext(context);

        var newChannel = Channel.builder().name("sanghoon").build();
        var newChannel2 = Channel.builder().name("sanghoon modified").build();
        var savedChannel = channelRepository.save(newChannel);

        savedChannel.updateChannel(newChannel2);

    }
    //given

    //when

    //then
}