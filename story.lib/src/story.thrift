namespace java com.teso.story.lib

typedef i64 long
typedef i32 int
struct category_storyLib{
   1:long id,
   2:storyLib storyC,
   3:categoryLib categoryS,
}

struct categoryLib{
   1:long id,
   2:string name,
   3:string link,
   4:list<category_storyLib> stories,
}

struct storyLib{
   1:long id,
   2:string name,
   3:string link,
   4:bool isFull,
   5:double rate,
   6:list<chapterLib> chapters,
   7:list<category_storyLib> categories,
   8:authorLib author,
}
struct chapterLib{
   1:long id,
   2:string name,
   3:string link,
   4:storyLib story,

}
struct authorLib{
   1:long id,
   2:string name,
   3:list<storyLib> stories,
}

service TStoryCrawlerService{
   bool crawAllStories();    
   bool crawAllCategories();
}
service TStoryDataService{
   string getAllStories();
   string getAllCategories();
   string getStoryByName(1:string name);
   string getStoryById(1:long id);
   string getStoryByAuthorId(1:long authorId);
   string getStoryByPageable(1:int itemPerPage 2:int pageNumber);
   string getChapterStoryByPageable(1:long storyId 2:int itemPerPage 3:int pageNumber);
   string getTotalPaginationStory(1:long storyId 2:int itemPerPage);
   string getQuantityStoryWithHighestRating(1:int quantity);
   string getQuantityStoryWithLowestRating(1:int quantity);
   string postAuthor(1:authorLib authorLib);
}