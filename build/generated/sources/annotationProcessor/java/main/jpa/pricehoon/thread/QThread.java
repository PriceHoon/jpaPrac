package jpa.pricehoon.thread;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QThread is a Querydsl query type for Thread
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QThread extends EntityPathBase<Thread> {

    private static final long serialVersionUID = -1187692612L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QThread thread = new QThread("thread");

    public final jpa.pricehoon.common.QTimeStamp _super;

    public final jpa.pricehoon.channel.QChannel channel;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt;

    // inherited
    public final jpa.pricehoon.user.QUser createdBy;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final SetPath<jpa.pricehoon.mention.Mention, jpa.pricehoon.mention.QMention> mentions = this.<jpa.pricehoon.mention.Mention, jpa.pricehoon.mention.QMention>createSet("mentions", jpa.pricehoon.mention.Mention.class, jpa.pricehoon.mention.QMention.class, PathInits.DIRECT2);

    public final StringPath message = createString("message");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt;

    // inherited
    public final jpa.pricehoon.user.QUser modifiedBy;

    public QThread(String variable) {
        this(Thread.class, forVariable(variable), INITS);
    }

    public QThread(Path<? extends Thread> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QThread(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QThread(PathMetadata metadata, PathInits inits) {
        this(Thread.class, metadata, inits);
    }

    public QThread(Class<? extends Thread> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new jpa.pricehoon.common.QTimeStamp(type, metadata, inits);
        this.channel = inits.isInitialized("channel") ? new jpa.pricehoon.channel.QChannel(forProperty("channel"), inits.get("channel")) : null;
        this.createdAt = _super.createdAt;
        this.createdBy = _super.createdBy;
        this.modifiedAt = _super.modifiedAt;
        this.modifiedBy = _super.modifiedBy;
    }

}

