drop table order_details;
drop table categories;
drop table order_details;
drop table orders;
drop table reviews;
drop table cart;
drop table books;
drop table members;


CREATE TABLE `books` (
  `book_id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(200) NOT NULL,
  `summary` VARCHAR(2000) NULL,
  `publisher` VARCHAR(100) NOT NULL,
  `image` VARCHAR(4000) NULL,
  `price` INT NOT NULL DEFAULT 0,
  `category_id` INT NULL,
  PRIMARY KEY (`book_id`),
  INDEX `category_id_idx` (`category_id` ASC) VISIBLE,
  CONSTRAINT `category_id`
    FOREIGN KEY (`category_id`)
    REFERENCES `categories` (`category_id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE);


CREATE TABLE `categories` (
  `category_id` INT NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(45) NOT NULL,
  `domestic` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`category_id`));
  
  
  CREATE TABLE `cart` (
  `cart_id` INT NOT NULL,
  `count` INT NOT NULL DEFAULT '1',
  PRIMARY KEY (`cart_id`),
  CONSTRAINT `book_id`
    FOREIGN KEY (`cart_id`)
    REFERENCES `books` (`book_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
    
    CREATE TABLE `members` (
  `member_id` INT NOT NULL AUTO_INCREMENT,
  `id` VARCHAR(45) NOT NULL,
  `pw` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(200) NULL,
  `email` VARCHAR(80) NOT NULL,
  `phone` VARCHAR(45) NULL,
  PRIMARY KEY (`member_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);
  
  CREATE TABLE `reviews` (
  `review_id` INT NOT NULL AUTO_INCREMENT,
  `book_id` INT NULL,
  `member_id` INT NULL,
  `rating` INT NULL DEFAULT 0,
  `title` VARCHAR(45) NOT NULL,
  `contents` VARCHAR(100) NULL,
  `writingtime` DATETIME NOT NULL,
  PRIMARY KEY (`review_id`),
  INDEX `book_id_idx` (`book_id` ASC) VISIBLE,
  INDEX `member_id_idx` (`member_id` ASC) VISIBLE,
  CONSTRAINT `book_id_reviews_books`
    FOREIGN KEY (`book_id`)
    REFERENCES `books` (`book_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `member_id_reviews_members`
    FOREIGN KEY (`member_id`)
    REFERENCES `members` (`member_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
    
    CREATE TABLE `order_details` (
  `order_id` INT NULL,
  `detail_id` INT NOT NULL AUTO_INCREMENT,
  `count` INT NULL,
  PRIMARY KEY (`detail_id`),
  INDEX `order_id_idx` (`order_id` ASC) VISIBLE,
  CONSTRAINT `order_id_orders_orderdetails`
    FOREIGN KEY (`order_id`)
    REFERENCES `orders` (`order_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
    
    
    CREATE TABLE `orders` (
  `order_id` INT NOT NULL AUTO_INCREMENT,
  `book_id` INT NULL,
  `member_id` INT NULL,
  `orderdate` DATETIME NULL,
  PRIMARY KEY (`order_id`),
  INDEX `book_id_idx` (`book_id` ASC) VISIBLE,
  INDEX `member_id_idx` (`member_id` ASC) VISIBLE,
  CONSTRAINT `book_id_orders_books`
    FOREIGN KEY (`book_id`)
    REFERENCES `books` (`book_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `member_id_orders_members`
    FOREIGN KEY (`member_id`)
    REFERENCES `members` (`member_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);