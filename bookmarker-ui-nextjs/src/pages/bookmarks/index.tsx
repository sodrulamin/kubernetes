import React from "react";
import {GetServerSideProps} from "next";
import {BookmarksResponse} from "@/services/models";
import {fetchBookmarks} from "@/services/api";
import Bookmarks from "@/components/bookmarks";
import SearchForm from "@/components/SearchForm";

interface HomeProps {
    bookmarks: BookmarksResponse
    searchKey?: string
}

export default function Home(props: HomeProps) {
    return (
        <div>
            <SearchForm/>
            <Bookmarks bookmarks={props.bookmarks} searchKey={props.searchKey} />
        </div>
    );
}

export const getServerSideProps: GetServerSideProps = async (context) => {
    const {page = 1, query = ""} = context.query;
    const bookmarks = await fetchBookmarks(parseInt(String(page)), String(query));
    return {
        props: {
            bookmarks,
            searchKey: String(String(query))
        }
    }
}