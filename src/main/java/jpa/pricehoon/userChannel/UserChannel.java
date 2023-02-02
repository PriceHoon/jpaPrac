package jpa.pricehoon.userChannel;

import jakarta.persistence.*;
import jpa.pricehoon.channel.Channel;
import jpa.pricehoon.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)


@Entity
@IdClass(UserChannelId.class)
public class UserChannel {

    //이 경우는 매핑 테이블 자체의 PK를 단일키로 만드는 경우
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    //User,Channel의 매핑 테이블이기 때문에 두 테이블의 pk를 fk로 가지고 있고, 그 둘로 table key지정하는 모습 ( 방법 1)
    //연관관계 부분에 @ID 붙이고, @IdClass를 따로 선언!

    //User,Channel의 매핑 테이블이기 때문에 두 테이블의 pk를 fk로 가지고 있고, 그 둘로 table key지정하는 모습 ( 방법 2)
    //이 때 연관관계 위에 붙었던 @Id는 전부 없애줌.
    // @EmbeddedId
    //  private UserChannelId userChannelId;


    /**
     * 컬럼 - 연관관계 컬럼을 제외한 컬럼을 정의합니다.
     */


    /**
     * 생성자 - 약속된 형태로만 생성가능하도록 합니다.
     */

    @Builder
    public UserChannel(User user, Channel  channel){
        this.user = user;
        this.channel = channel;
    }

    /**
     * 연관관계 - Foreign Key 값을 따로 컬럼으로 정의하지 않고 연관 관계로 정의합니다.
     */


    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "channel_id")
    private Channel channel;



    /**
     * 연관관계 편의 메소드 - 반대쪽에는 연관관계 편의 메소드가 없도록 주의합니다.
     */


    /**
     * 서비스 메소드 - 외부에서 엔티티를 수정할 메소드를 정의합니다. (단일 책임을 가지도록 주의합니다.)
     */

}
