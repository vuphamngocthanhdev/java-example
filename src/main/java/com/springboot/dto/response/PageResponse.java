package com.springboot.dto.response;

import lombok.Builder;
import lombok.Getter;

/**
 * A generic class that represents a paginated response for API calls.
 * It encapsulates details about the current page, total pages, and
 * the items contained on the current page.
 *
 * @author Thanh
 */
@Getter
@Builder
public class PageResponse<T> {
	/**
	* <T> the type of the items being paginated, can be a list or any other collection
	* <p>
	* Attributes:
	* pageNo the current page number being returned (starting from 0 or 1 depending on implementation)
	* pageSize the number of items contained in each page
	* totalPage the total number of pages available based on the data
	* items the actual data or items for the current page (can be a collection or any type)
	*/
	int pageNo;
	int pageSize;
	int totalPage;
	T items;
}
