import { CommentModel } from './comment.model';

export class TopicModel {
	id: number;
	title: string;
	mediaUrl: string;
	author: string;
	upVote: number;
	downVote: number;
	popularity: number;
	comments: CommentModel[];
}
