
export interface BookmarksResponse {
    data: Bookmark[],
    totalElements: number,
    currentPage: number,
    totalPages: number,
    isFirst: boolean,
    isLast: boolean,
    hasNext: boolean,
    hasPrev: boolean
}

export interface Bookmark {
    id: number,
    title: string,
    url: string,
    created_at: Date,
    updated_at: Date
}