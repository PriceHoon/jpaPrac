package jpa.pricehoon.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -1272985508L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUser user = new QUser("user");

    public final QAddress address;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final SetPath<jpa.pricehoon.mention.Mention, jpa.pricehoon.mention.QMention> mentions = this.<jpa.pricehoon.mention.Mention, jpa.pricehoon.mention.QMention>createSet("mentions", jpa.pricehoon.mention.Mention.class, jpa.pricehoon.mention.QMention.class, PathInits.DIRECT2);

    public final StringPath password = createString("password");

    public final SetPath<jpa.pricehoon.userChannel.UserChannel, jpa.pricehoon.userChannel.QUserChannel> userChannels = this.<jpa.pricehoon.userChannel.UserChannel, jpa.pricehoon.userChannel.QUserChannel>createSet("userChannels", jpa.pricehoon.userChannel.UserChannel.class, jpa.pricehoon.userChannel.QUserChannel.class, PathInits.DIRECT2);

    public final StringPath username = createString("username");

    public QUser(String variable) {
        this(User.class, forVariable(variable), INITS);
    }

    public QUser(Path<? extends User> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUser(PathMetadata metadata, PathInits inits) {
        this(User.class, metadata, inits);
    }

    public QUser(Class<? extends User> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new QAddress(forProperty("address")) : null;
    }

}

