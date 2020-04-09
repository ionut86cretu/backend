import { CommentModel } from './comment.model';

export class TopicModel {
	title: string;
	mediaUrl: string;
	author: string;
	comments: CommentModel[];
}
