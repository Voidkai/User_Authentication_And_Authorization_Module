CREATE DATABASE IF NOT EXISTS `java_reference_test` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `java_reference_test`;
DROP TABLE IF EXISTS `privileges`;
CREATE TABLE `privileges` (
  `privilege_id` int(11) NOT NULL,
  `privilege_code` varchar(50) NOT NULL,
  `description` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
TRUNCATE TABLE `privileges`;
INSERT INTO `privileges` (`privilege_id`, `privilege_code`, `description`) VALUES
(100, 'service_ticket_truncate', ''),
(101, 'service_ticket_create', ''),
(102, 'service_ticket_read', ''),
(103, 'service_ticket_update', ''),
(104, 'service_ticket_delete', '');
DROP TABLE IF EXISTS `privilege_role`;
CREATE TABLE `privilege_role` (
  `id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `privilege_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
TRUNCATE TABLE `privilege_role`;
INSERT INTO `privilege_role` (`id`, `role_id`, `privilege_id`) VALUES
(1, 1, 100),
(2, 1, 101),
(3, 1, 102),
(4, 1, 103),
(5, 1, 104),
(6, 2, 102),
(7, 2, 103),
(8, 3, 101),
(9, 3, 102),
(10,3, 103);
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `role_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
TRUNCATE TABLE `roles`;
INSERT INTO `roles` (`role_id`, `name`) VALUES
(1, 'service_ticket_manager'),
(2, 'service_ticket_processor'),
(3, 'customer');
DROP TABLE IF EXISTS `role_user`;
CREATE TABLE `role_user` (
  `id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
TRUNCATE TABLE `role_user`;
DROP TABLE IF EXISTS `service_ticket`;
CREATE TABLE `service_ticket` (
  `id` int(11) NOT NULL,
  `update_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `user_id` int(11) NOT NULL,
  `content` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
TRUNCATE TABLE `service_ticket`;
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
TRUNCATE TABLE `users`;
ALTER TABLE `privileges`
  ADD PRIMARY KEY (`privilege_id`);
ALTER TABLE `privilege_role`
  ADD PRIMARY KEY (`id`);
ALTER TABLE `roles`
  ADD PRIMARY KEY (`role_id`);
ALTER TABLE `role_user`
  ADD PRIMARY KEY (`id`);
ALTER TABLE `service_ticket`
  ADD PRIMARY KEY (`id`);
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);
ALTER TABLE `privilege_role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
ALTER TABLE `role_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=0;
ALTER TABLE `service_ticket`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=0;