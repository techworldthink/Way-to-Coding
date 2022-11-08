import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Blog {
	String title;
	BlogPostType type;
	int views;

	Blog() {
	}

	Blog(String title, BlogPostType type, int views) {
		this.title = title;
		this.type = type;
		this.views = views;
	}

	@Override
	public String toString() {
		return title;
		// return "Title :: " + this.title + "\tType :: " + this.type + "\tViews :: " +
		// this.views;
	}

	public BlogPostType getType() {
		return this.type;
	}

	public int getViews() {
		return this.views;
	}
}

enum BlogPostType {
	POEM,
	NEWS,
	REVIEW,
	GUIDE
}

class GroupingByDemo {

	public static void main(String[] args) {

		Blog obj_1 = new Blog("A", BlogPostType.POEM, 123);
		Blog obj_2 = new Blog("B", BlogPostType.NEWS, 13);
		Blog obj_3 = new Blog("C", BlogPostType.POEM, 23);
		Blog obj_4 = new Blog("D", BlogPostType.REVIEW, 1230);
		Blog obj_5 = new Blog("E", BlogPostType.POEM, 56);

		List<Blog> data = Arrays.asList(obj_1, obj_2, obj_3, obj_4, obj_5);

		// print data
		data.forEach(
				(each) -> System.out.println(each));

		// group by - type
		Map<BlogPostType, List<Blog>> byTypeData = data.stream().collect(Collectors.groupingBy(Blog::getType));
		byTypeData.forEach(
				(key, value) -> System.out.println(key + "\t" + value));

		// group by - type and get total count
		Map<BlogPostType, Long> byCountData = data.stream()
				.collect(Collectors.groupingBy(Blog::getType, Collectors.counting()));
		byCountData.forEach(
				(key, value) -> System.out.println(key + "\t" + value));

		// group by - type and get total view
		Map<BlogPostType, Integer> byViewata = data.stream()
				.collect(Collectors.groupingBy(Blog::getType, Collectors.summingInt(Blog::getViews)));
		byViewata.forEach(
				(key, value) -> System.out.println(key + "\t" + value));

		// group by - type - Modifying the Returned Map Value Type
		Map<BlogPostType, Set<Blog>> byTypeDataReturnSet = data.stream()
				.collect(Collectors.groupingBy(Blog::getType, Collectors.toSet()));
		byTypeDataReturnSet.forEach(
				(key, value) -> System.out.println(key + "\t" + value));

		// group by multiple fields
		Map<BlogPostType, Map<Integer, List<Blog>>> byTypeByViewsData = data.stream()
				.collect(Collectors.groupingBy(Blog::getType, Collectors.groupingBy(Blog::getViews)));
		byTypeByViewsData.forEach(
				(key, value) -> System.out.println(key + "\t" + value));

		// group by - type - Modifying the Returned Map Value Type
		Map<BlogPostType, IntSummaryStatistics> summarizeData = data.stream()
				.collect(Collectors.groupingBy(Blog::getType, Collectors.summarizingInt(Blog::getViews)));
		summarizeData.forEach(
				(key, value) -> System.out.println(key + "\t" + value));

	}
}