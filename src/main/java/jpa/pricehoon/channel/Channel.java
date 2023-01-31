package jpa.pricehoon.channel;

import jakarta.persistence.*;

@Entity
public class Channel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING) // String타입으로 저장하겠다.
    private Type ChannelType;

    public enum Type{
        PUBLIC,
        PRIVATE
    }



}
