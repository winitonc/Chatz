package io.github.jhipster.application.repository;

public class NamedQuery {

    public static final String GET_ALL_CUSTOMERS = "Select customer_id        AS customerId, social_id AS socialId, social_name        AS socialName, first_name         AS fistName, last_name          AS lastName, address            AS address, image_url          AS imageUrl, phone              AS phone, email              AS email, c.create_date      AS createDate, c.update_date      AS updateDate, c.status           AS status, channel.name       AS channel, customer_type.name AS customerType, lastMessageDateTime AS lastMessageDateTime FROM (SELECT m.customer_id, max(m.create_date) AS lastMessageDateTime FROM message m group by m.customer_id) m LEFT JOIN customer c ON m.customer_id = c.id LEFT JOIN channel ON c.channel_id = channel.id LEFT JOIN customer_type ON c.customer_type_id = customer_type.id";
    public static final String GET_CUSTOMER_BY_CUSTOMER_ID = "Select customer_id         AS customerId, social_id AS socialId, social_name         AS socialName, first_name          AS fistName, last_name           AS lastName, address             AS address, image_url           AS imageUrl, phone               AS phone, email               AS email, c.create_date       AS createDate, c.update_date       AS updateDate, c.status            AS status, channel.name        AS channel, customer_type.name  AS customerType, lastMessageDateTime AS lastMessageDateTime FROM (SELECT m.customer_id, max(m.create_date) AS lastMessageDateTime FROM message m WHERE m.customer_id = :customerId group by m.customer_id) m LEFT JOIN customer c ON m.customer_id = c.id LEFT JOIN channel ON c.channel_id = channel.id LEFT JOIN customer_type ON c.customer_type_id = customer_type.id";
    public static final String GET_CUSTOMER_BY_SOCIAL_ID = "select id                  AS customerId, social_id           AS socialId, social_name         AS socialName, first_name          AS fistName, last_name           AS lastName, address             AS address, image_url           AS imageUrl, phone               AS phone, email               AS email, create_date         AS createDate, update_date         AS updateDate, status              AS status, (select name from channel where id = channel_id) AS channel, (select name from customer_type where id = customer_type_id) AS customerType FROM customer WHERE social_id = :socialId";
    public static final String GET_ALL_MESSAGE_BY_CUSTOMER_ID = "SELECT m.status AS status, message, m.create_date AS createDate, type, (select name from channel where id = channel_id)       AS channel, (select name from customer_type where id = customer_type_id) AS customerType FROM message m LEFT JOIN customer c ON c.id = m.customer_id WHERE customer_id = :customerId ORDER BY m.create_date";
    public static final String SAVE_CUSTOMER = "INSERT INTO customer (social_id, social_name, image_url, channel_id) SELECT :socialId, :socialName, :imageUrl, (SELECT c.id FROM channel c WHERE c.name= :channel) WHERE NOT EXISTS (SELECT social_id FROM customer WHERE social_id = :socialId)";
    public static final String SAVE_MESSAGE = "INSERT INTO message (message, type, customer_id, status) VALUES (:message, :type, :customerId, :status)";
    public static final String UPDATE_CUSTOMER = "UPDATE customer SET social_name = :socialName, image_url = :imageUrl WHERE id = :customerId";
}