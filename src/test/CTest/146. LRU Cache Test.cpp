#include "gtest/gtest.h"
#include "../../main/c++/header/LRUCache.h"

class LRUCacheTest : public ::testing::Test {
protected:
	void SetUp() override {}

	void TearDown() override {}
};

TEST_F(LRUCacheTest, methodTest) {

	LRUCache* cache = new LRUCache(3);
	cache->put(1, 1);
	cache->put(2, 2);
	cache->put(3, 3);
	cache->put(4, 4);
	EXPECT_EQ(4, cache->get(4));
	EXPECT_EQ(3, cache->get(3));
	EXPECT_EQ(2, cache->get(2));
	EXPECT_EQ(-1, cache->get(1));
	cache->put(5, 5);
	EXPECT_EQ(-1, cache->get(1));
	EXPECT_EQ(2, cache->get(2));
	EXPECT_EQ(3, cache->get(3));
	EXPECT_EQ(-1, cache->get(4));
	EXPECT_EQ(5, cache->get(5));
	delete cache;

	cache = new LRUCache(2);
	cache->put(1, 1);
	cache->put(2, 2);
	EXPECT_EQ(1, cache->get(1));
	cache->put(3, 3);
	EXPECT_EQ(-1, cache->get(2));
	cache->put(4, 4);
	EXPECT_EQ(-1, cache->get(1));
	EXPECT_EQ(3, cache->get(3));
	EXPECT_EQ(4, cache->get(4));
	delete cache;

	cache = new LRUCache(1);
	cache->put(2, 1);
	EXPECT_EQ(1, cache->get(2));
	cache->put(3, 2);
	EXPECT_EQ(-1, cache->get(2));
	EXPECT_EQ(2, cache->get(3));
	delete cache;
}