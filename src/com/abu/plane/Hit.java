package com.abu.plane;

class Hit {

	private int enemy_x, enemy_y;
	private int bullet_x, bullet_y;
	boolean alive;

	private Enemy Enemy = new Enemy(enemy_x, enemy_y);
	private Bullet Bullet = new Bullet(bullet_x, bullet_y);

	boolean HitEffort(){
		return Bullet.local_x >= Enemy.local_x
				&& Bullet.local_x <= Enemy.local_x + 80
				&& Bullet.local_y >= Enemy.local_y +5
				&& Bullet.local_y <= Enemy.local_y -5;
	}

}
